package diary_project.backend.board.controller;

import diary_project.backend.board.dto.BoardRequest;
import diary_project.backend.board.entity.Board;
import diary_project.backend.board.repository.BoardRepository;
import diary_project.backend.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "api/board")
public class BoardContoller {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("board/new")
    public Board create(@RequestMapping BoardRequest request){
        return BoardRepository.save(request.getBoard())
    }
}
