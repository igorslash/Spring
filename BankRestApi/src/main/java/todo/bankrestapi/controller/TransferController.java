@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
@Tag(name = "Переводы", description = "Переводы между своими картами")
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Совершить перевод", description = "Только между своими активными картами")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Перевод выполнен"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации или недостаточно средств"),
            @ApiResponse(responseCode = "403", description = "Попытка перевода чужой карты")
    })
    public ResponseEntity<Void> makeTransfer(@Valid @RequestBody TransferRequest request, Authentication authentication) {
        // ... существующая реализация
    }
}