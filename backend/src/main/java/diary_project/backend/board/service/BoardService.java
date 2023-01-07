package diary_project.backend.board.service;


import diary_project.backend.board.dto.BoardDto;
import diary_project.backend.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<BoardDto> postBoard(){
        return boardMapper.postBoard();
    }

}
