package diary_project.backend.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Board {
    @Id
    @GeneratedValue
    private int boardinx;
    private String title;
    private String maintext;
    private int hitcnt;
    private String creatorId;
    private String date;
    private String updateId;
    private LocalDateTime updateDatetime;

}
