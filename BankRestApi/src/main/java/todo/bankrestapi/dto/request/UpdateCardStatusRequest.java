package todo.bankrestapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import todo.bankrestapi.model.CardStatus;
@Getter
@Setter
@RequiredArgsConstructor
public class UpdateCardStatusRequest {
    @NotNull(message = "Статус обязателен")
    private CardStatus status;
}