package diary_project.backend.board.dto;

import java.time.LocalDateTime;

import diary_project.backend.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDto {
    private Board board;
}


