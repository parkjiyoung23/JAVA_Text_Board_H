package com.pjy.exam.board.Controller;

import com.pjy.exam.board.Container.Container;
import com.pjy.exam.board.Rq;
import com.pjy.exam.board.dto.Member;
import com.pjy.exam.board.service.MemberService;

public class UsrMemberController {
  private MemberService memberService;


  public UsrMemberController() {
    memberService = Container.getMemberService();
    memberService.makeTestData();
  }

  public void actionJoin() {
    System.out.println("== 회원 가입 ==");
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.getSc().nextLine();
    System.out.printf("로그인 비밀번호 : ");
    String loginPw = Container.getSc().nextLine();
    System.out.printf("로그인 비밀번호 확인 : ");
    String loginPwConfirm = Container.getSc().nextLine();

    if ( loginPw.equals(loginPwConfirm) == false) {
      System.out.println("비밀번호가 일치하지 않습니다.");
      return;
    }

    int id = memberService.join(loginId, loginPw);

    System.out.printf("%s님. 가입을 환영합니다.\n", loginId);
    System.out.printf("%d번 회원이 생성 되었습니다.\n", id);
  }
  public void actionLogin(Rq rq) {
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.getSc().nextLine().trim();

    if(loginId.length() == 0 ) {
      System.out.println("로그인 아이디를 입력해주세요.");
      return;
    }

    Member member = memberService.getMemberByLoginId(loginId);

    if ( member == null) {
      System.out.println("해당 회원은 존재하지 않습니다.");
      return;
    }

    System.out.printf("로그인 비밀번호 : ");
    String loginPw = Container.getSc().nextLine().trim();

    if(loginPw.length() == 0) {
      System.out.println("로그인 비밀번호를 입력해주세요.");
      return;
    }

    if (member.getLoginPw().equals(loginPw) == false) {
      System.out.println("비밀번호가 일치하지 않습니다.");
      return;
    }
    rq.setSessionAttr("loginedMember",member);
    System.out.printf("%s님 환영합니다.\n", member.getLoginId());
  }


  public void actionLogout(Rq rq) {
    Member loginedMember = (Member) Container.getSession().getAttribute("loginedMember");
    if(loginedMember == null) {
      System.out.println("로그인 후 이용해주세요.");
      return;
    }
    else {
      rq.removeSessionAttr("loginedMember");
    }

    System.out.println("로그아웃 되었습니다.");
  }
}
