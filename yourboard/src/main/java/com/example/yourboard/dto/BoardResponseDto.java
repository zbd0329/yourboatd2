package com.example.yourboard.dto;

import com.example.yourboard.entity.Board;
import com.example.yourboard.entity.Reple;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.attoparser.dom.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String username;
    private String comment; //내용 contents
    private String title;
    private LocalDateTime ModifiedAt;
    private LocalDateTime createdAt;

    private List<RepleResponseDto> repleList = new ArrayList<>();

//    private List<RepleResponseDto>  repleList; //아오


    //서비스에서 리턴할때 객체값에 들어가기 때문에 작성해줘야한다. Get으로 내용을 받아옴. 함수처럼 쓰이고 있음.
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.username = board.getUsername();;
        this.title = board.getTitle();
        this.comment = board.getComment();
        this.ModifiedAt = board.getModifiedAt();
        this.createdAt = board.getCreatedAt();
//        List<RepleResponseDto> repleList = new ArrayList<>(); //리플 준영님
//        for(Reple reple : board.getRepleList() ) {
//            repleList.add(new RepleResponseDto(reple));
//        } this.repleList = repleList;

    }

    public BoardResponseDto(Board board, List<RepleResponseDto> repleList){
        this.id = board.getId();
        this.username = board.getUsername();
        this.title = board.getTitle();
        this.comment = board.getComment();
        this.createdAt = board.getCreatedAt();
        this.ModifiedAt = board.getModifiedAt();
        this.repleList = repleList;
    }

}
