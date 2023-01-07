package diary_project.backend.board.dto;

import java.time.LocalDateTime;
import lombok.Data;


public class BoardDto {
    private int boardinx;
    private String title;
    private String maintext;
    private int hitcnt;
    private String creatorId;
    private String date;
    private String updateId;
    private LocalDateTime updateDatetime;


    public void setTitle(String title){
        this.title = title;
    }
    public void setMaintext(String maintext){
        this.maintext = maintext;
    }
    public void setDate(String date){
        this.date = date;
    }

}


