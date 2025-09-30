@SpringBootTest
@Transactional
class TransferServiceTest {

    @Autowired
    private TransferService transferService;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    private User user;
    private Card fromCard;
    private Card toCard;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setEmail("user@test.com");
        user.setPassword("pass");
        user.setRole(Role.USER);
        user = userRepository.save(user);

        fromCard = createCard("4111111111111111", BigDecimal.valueOf(2000));
        toCard = createCard("5555555555554444", BigDecimal.valueOf(500));
    }

    @Test
    void transfer_ShouldUpdateBalances_WhenValidRequest() {
        TransferRequest request = new TransferRequest();
        request.setFromCardId(fromCard.getId());
        request.setToCardId(toCard.getId());
        request.setAmount(BigDecimal.valueOf(500));

        transferService.transfer(request, user.getId());

        Card updatedFrom = cardRepository.findById(fromCard.getId()).get();
        Card updatedTo = cardRepository.findById(toCard.getId()).get();

        assertEquals(BigDecimal.valueOf(1500), updatedFrom.getBalance());
        assertEquals(BigDecimal.valueOf(1000), updatedTo.getBalance());
    }

    @Test
    void transfer_ShouldThrowException_WhenInsufficientFunds() {
        TransferRequest request = new TransferRequest();
        request.setFromCardId(fromCard.getId());
        request.setToCardId(toCard.getId());
        request.setAmount(BigDecimal.valueOf(3000));

        assertThrows(IllegalStateException.class, () -> {
            transferService.transfer(request, user.getId());
        });
    }

    private Card createCard(String number, BigDecimal balance) {
        String encrypted = encryptionUtil.encrypt(number);
        Card card = new Card();
        card.setUser(user);
        card.setEncryptedCardNumber(encrypted);
        card.setCardHolder("Test");
        card.setExpiryDate(LocalDate.of(2027, 12, 31));
        card.setStatus(CardStatus.ACTIVE);
        card.setBalance(balance);
        return cardRepository.save(card);
    }
}