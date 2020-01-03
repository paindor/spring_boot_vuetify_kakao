package com.newboot.web.util;


import java.util.function.Consumer;

import org.springframework.stereotype.Service;

@Service
public class Printer implements Consumer{

	@Override
	public void accept(Object o) {
		Consumer<String> c = System.out :: println;
		c.accept((String)o);
	}

}