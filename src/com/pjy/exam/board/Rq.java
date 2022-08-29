package com.pjy.exam.board;

import com.pjy.exam.board.Container.Container;
import com.pjy.exam.board.Util.util;
import com.pjy.exam.board.dto.Member;

import java.util.Map;

public class Rq{
  private String url;
  private String urlPath;
  private Map<String, String> params;

  public Rq(){

  }
 public Rq(String url){
    this.url = url;
    this.urlPath = util.getUrlPathFromUrl(this.url);
    params = util.getParamsFromUrl(this.url);
  }
  public Map<String, String> getParams(){
    return params;
  }
  public int getIntParam(String paramName, int defaultValue) {

    if (params.containsKey(paramName) == false) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(params.get(paramName));
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {

    if (params.containsKey(paramName) == false) {
      return defaultValue;
    }

    return params.get(paramName);
  }
  public String getUrlPath(){

    return urlPath;
  }
  public Member getLoginedMember() {
    return (Member) getSessionAttr("loginedMember");
  }

  private Object getSessionAttr(String key) {
    Session session = Container.getSession();

    return session.getAttribute(key);
  }
  public void setSessionAttr(String key, Member value) {
    com.pjy.exam.board.Session session = Container.getSession();

    session.setAttribute(key, value);
  }
  public void removeSessionAttr(String key) {
    com.pjy.exam.board.Session session = Container.getSession();

    session.removeAttribute(key);
  }
  public void setCommand(String url) {
    urlPath = util.getUrlPathFromUrl(url);
    params = util.getParamsFromUrl(url);
  }

  public boolean isLogined() {
    return hasSessionAttr("loginedMember");
  }

  public boolean hasSessionAttr(String key) {
    Session session = Container.getSession();

    return session.hasAttribute(key);
  }

  public void logout() {
    removeSessionAttr("loginedMember");
  }

  public void login(Member member) {
    setSessionAttr("loginedMember", member);
  }
}
