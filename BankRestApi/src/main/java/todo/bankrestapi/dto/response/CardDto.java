public class CardDto {
    private Long id;
    private String maskedCardNumber;
    private String cardHolder;
    private String expiryDate;
    private CardStatus status;
    private BigDecimal balance;
    private LocalDateTime createdAt;


    public CardDto(Card card, String decryptedCardNumber) {
        this.id = card.getId();
        this.maskedCardNumber = MaskUtil.maskCardNumber(decryptedCardNumber);
        this.cardHolder = card.getCardHolder();
        this.expiryDate = card.getExpiryDate().format(DateTimeFormatter.ofPattern("MM/yy"));
        this.status = card.getStatus();
        this.balance = card.getBalance();
        this.createdAt = card.getCreatedAt();
    }

    public Long getId() { return id; }
    public String getMaskedCardNumber() { return maskedCardNumber; }
    public String getCardHolder() { return cardHolder; }
    public String getExpiryDate() { return expiryDate; }
    public CardStatus getStatus() { return status; }
    public BigDecimal getBalance() { return balance; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}