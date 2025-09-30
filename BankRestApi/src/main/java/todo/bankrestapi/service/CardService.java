@Service
@Transactional
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final EncryptionUtil encryptionUtil;


    public CardDto createCard(CreateCardRequest request, Long requesterId) {
        User targetUser;
        if (request.getUserId() != null) {
            targetUser = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        } else {
            targetUser = userRepository.findById(requesterId)
                    .orElseThrow(() -> new EntityNotFoundException("Ваш профиль не найден"));
        }


        LocalDate expiryDate = parseExpiryDate(request.getExpiryDate());

        String encryptedNumber = encryptionUtil.encrypt(request.getCardNumber());

        Card card = new Card();
        card.setUser(targetUser);
        card.setEncryptedCardNumber(encryptedNumber);
        card.setCardHolder(request.getCardHolder());
        card.setExpiryDate(expiryDate);
        card.setStatus(CardStatus.ACTIVE);
        card.setBalance(BigDecimal.ZERO);

        Card savedCard = cardRepository.save(card);

        String decryptedNumber = encryptionUtil.decrypt(savedCard.getEncryptedCardNumber());
        return new CardDto(savedCard, decryptedNumber);
    }


    public Page<CardDto> getUserCards(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Card> cards = cardRepository.findByUserId(userId, pageable);

        return cards.map(card -> {
            String decrypted = encryptionUtil.decrypt(card.getEncryptedCardNumber());
            return new CardDto(card, decrypted);
        });
    }


    public Page<CardDto> getAllCards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Card> cards = cardRepository.findAll(pageable);

        return cards.map(card -> {
            String decrypted = encryptionUtil.decrypt(card.getEncryptedCardNumber());
            return new CardDto(card, decrypted);
        });
    }


    public CardDto updateCardStatus(Long cardId, CardStatus newStatus, Long requesterId, boolean isAdmin) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Карта не найдена"));


        if (!isAdmin && !card.getUser().getId().equals(requesterId)) {
            throw new AccessDeniedException("Нет прав на изменение этой карты");
        }


        if (!isAdmin && newStatus != CardStatus.BLOCKED) {
            throw new AccessDeniedException("Пользователь может только запросить блокировку карты");
        }

        card.setStatus(newStatus);
        Card updatedCard = cardRepository.save(card);

        String decrypted = encryptionUtil.decrypt(updatedCard.getEncryptedCardNumber());
        return new CardDto(updatedCard, decrypted);
    }


    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Карта не найдена"));
    }


    public void validateCardOwnership(Card card, Long userId) {
        if (!card.getUser().getId().equals(userId)) {
            throw new AccessDeniedException("Карта не принадлежит вам");
        }
    }

    private LocalDate parseExpiryDate(String expiryStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth yearMonth = YearMonth.parse(expiryStr, formatter);
            return yearMonth.atEndOfMonth();
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат срока действия. Используйте MM/yy, например 05/27");
        }
    }
}