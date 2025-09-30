@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {

    private final CardRepository cardRepository;
    private final CardService cardService;

    public void transfer(TransferRequest request, Long requesterId) {

        Card fromCard = cardService.getCardById(request.getFromCardId());
        Card toCard = cardService.getCardById(request.getToCardId());

        cardService.validateCardOwnership(fromCard, requesterId);
        cardService.validateCardOwnership(toCard, requesterId);


        if (fromCard.getStatus() != CardStatus.ACTIVE) {
            throw new IllegalStateException("Карта отправителя не активна");
        }
        if (toCard.getStatus() != CardStatus.ACTIVE) {
            throw new IllegalStateException("Карта получателя не активна");
        }


        if (fromCard.getBalance().compareTo(request.getAmount()) < 0) {
            throw new IllegalStateException("Недостаточно средств на карте отправителя");
        }


        fromCard.setBalance(fromCard.getBalance().subtract(request.getAmount()));
        toCard.setBalance(toCard.getBalance().add(request.getAmount()));

        cardRepository.save(fromCard);
        cardRepository.save(toCard);
    }
}