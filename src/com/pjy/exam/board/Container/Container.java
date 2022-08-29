package com.pjy.exam.board.Container;

import com.pjy.exam.board.Controller.UsrArticleController;
import com.pjy.exam.board.Controller.UsrMemberController;
import com.pjy.exam.board.repository.ArticleRepository;
import com.pjy.exam.board.repository.MemberRepository;
import com.pjy.exam.board.service.ArticleService;
import com.pjy.exam.board.service.MemberService;
import lombok.Getter;

import java.util.Scanner;

public class Container {
  @Getter
  private static Scanner sc ;
  @Getter
  private static com.pjy.exam.board.Session session;
  @Getter
  private static MemberRepository memberRepository;
  @Getter
  private static ArticleRepository articleRepository;
  @Getter
  private static ArticleService articleService;
  @Getter
  private static MemberService memberService;
  @Getter
  private static UsrArticleController usrArticleController;
  @Getter
  private static UsrMemberController usrMemberController;
  static {
    sc = new Scanner(System.in);
    session = new com.pjy.exam.board.Session();

    articleRepository = new ArticleRepository();
    memberRepository = new MemberRepository();

    articleService = new ArticleService();
    memberService = new MemberService();

    usrArticleController = new UsrArticleController();
    usrMemberController = new UsrMemberController();
  }
  public static com.pjy.exam.board.Session getSession(){
    return session;
  }

}
