package diary_project.backend.board.controller;

import diary_project.backend.board.service.BoardService;
import diary_project.backend.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "api/board")
public class BoardContoller {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "postBoard", method = RequestMethod.POST)
    public ResponseEntity<?> postBoard() {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("test1");
        boardDto.setMaintext("what do i do");
        boardDto.setDate("1104");

        return new ResponseEntity<>(boardDto, HttpStatus.OK);
    }
}
