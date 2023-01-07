package diary_project.backend.board.mapper;

import diary_project.backend.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<BoardDto> postBoard();
}
