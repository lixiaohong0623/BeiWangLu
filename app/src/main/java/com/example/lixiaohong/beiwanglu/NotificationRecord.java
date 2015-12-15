package com.example.lixiaohong.beiwanglu;

import com.example.lixiaohong.beiwanglu.DataBase.NotificationDatabase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by li.xiaohong on 2015/12/14.
 */
public class NotificationRecord {
  private int id;
  private long dateCreate;
  private long dateNotify;
  private String contentText;
  private String contentImageUri;
  private String contentAudioUri;
  private ArrayList<String> menNotify;
  private int isOvertime;

  public  NotificationRecord(int id, long dateCreate, long dateNotify, String text, String imageUri, String audioUri, ArrayList<String> men, int isOvertime) {
    this.id = id;
    this.dateCreate = dateCreate;
    this.dateNotify = dateNotify;
    this.contentText = text;
    this.contentImageUri = imageUri;
    this.contentAudioUri = audioUri;
    this.menNotify = men;
    this.isOvertime = isOvertime;
  }
}
