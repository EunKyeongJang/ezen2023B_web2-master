package ezenweb.controller;

import com.sun.tools.jconsole.JConsoleContext;
import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.PageDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody( Content-Type:application/json )  : 데이터 주고 받는 REST 역할
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/post.do")
    public boolean postBoard(BoardDto boardDto){
        System.out.println("boardDto = " + boardDto);
        return boardService.postBoard(boardDto); }
    @GetMapping("/get.do")
    public PageDto getBoard(int page, int view){
        System.out.println("page = " + page + ", view = " + view);
        return boardService.getBoard(page, view);
    }
    @PutMapping("/put.do")
    public boolean putBoard(){
        return boardService.putBoard();
    }
    @DeleteMapping("/delete.do")
    public boolean deleteBoard(int bno, int mno_fk){
        System.out.println("BoardController.deleteBoard");
        return boardService.deleteBoard(bno,mno_fk);
    }


}









