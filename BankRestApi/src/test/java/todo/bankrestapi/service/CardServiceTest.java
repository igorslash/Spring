@SpringBootTest
@Transactional
class CardServiceTest {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private EncryptionUtil encryptionUtil;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setEmail("test@example.com");
        testUser.setPassword("encoded");
        testUser.setRole(Role.USER);
        testUser = userRepository.save(testUser);
    }

    @Test
    void createCard_ShouldReturnCardDto_WhenValidRequest() {
        CreateCardRequest request = new CreateCardRequest();
        request.setCardNumber("4111111111111111");
        request.setCardHolder("John Doe");
        request.setExpiryDate("12/27");

        CardDto cardDto = cardService.createCard(request, testUser.getId());

        assertNotNull(cardDto.getId());
        assertEquals("**** **** **** 1111", cardDto.getMaskedCardNumber());
        assertEquals(CardStatus.ACTIVE, cardDto.getStatus());
        assertEquals(BigDecimal.ZERO, cardDto.getBalance());
    }

    @Test
    void getUserCards_ShouldReturnPage_WhenCardsExist() {
        // Создаем 2 карты
        createTestCard("4111111111111111");
        createTestCard("5555555555554444");

        Page<CardDto> cards = cardService.getUserCards(testUser.getId(), 0, 10);

        assertEquals(2, cards.getTotalElements());
        assertEquals("**** **** **** 1111", cards.getContent().get(0).getMaskedCardNumber());
    }

    private void createTestCard(String number) {
        String encrypted = encryptionUtil.encrypt(number);
        Card card = new Card();
        card.setUser(testUser);
        card.setEncryptedCardNumber(encrypted);
        card.setCardHolder("Test Holder");
        card.setExpiryDate(LocalDate.of(2027, 12, 31));
        card.setStatus(CardStatus.ACTIVE);
        card.setBalance(BigDecimal.valueOf(1000.00));
        cardRepository.save(card);
    }
}