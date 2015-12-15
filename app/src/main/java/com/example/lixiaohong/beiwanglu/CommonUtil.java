package com.example.lixiaohong.beiwanglu;

import java.util.ArrayList;

/**
 * Created by li.xiaohong on 2015/12/15.
 */
public class CommonUtil {
  public ArrayList<String> phoneStringToList(String phoneString){
    ArrayList<String> phoneList = new ArrayList<String>();
    if (phoneString == null) return null;
    String[] splitString = phoneString.split(";");
    for(String phone: splitString){
      phoneList.add(phone);
    }
    return  phoneList;
  }
}
