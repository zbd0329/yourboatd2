package com.example.yourboard.entity;

import com.example.yourboard.dto.RepleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Reple extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reple;

    @ManyToOne
    @JoinColumn(name ="userId", nullable = false)
    private User user; // >>>>> 어디서 찾아서 껴넣어 줄것이냐.

    @ManyToOne
    @JoinColumn(name ="boardId", nullable = false)
    private Board board;

    public Reple(String reple, User user, Board board) {
        this.reple = reple;
        this.user = user;
        this.board =board;
    }

    public Reple(RepleRequestDto repleRequestDto) {
        this.reple = repleRequestDto.getReple();
    }

    //생성자 죽여버려

    @Transactional
    public void update(RepleRequestDto repleRequestDto) {
        this.reple = repleRequestDto.getReple();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReple(String reple) {
        this.reple = reple;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
