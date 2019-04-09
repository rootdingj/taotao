package com.dj.taotao.sso.service;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbUser;

public interface UserService {
	
	TaotaoResult checkData(String param, int type);
	TaotaoResult register(TbUser user);
	TaotaoResult login(String username,String password);

}
