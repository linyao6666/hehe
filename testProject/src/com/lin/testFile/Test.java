package com.lin.testFile;

public class Test {
	public static void main(String[] args) {
		for(int i=0;i<10000000;i++){
			if( i%2 == 1){
				if(i%3 == 0){
					if(i%4 == 1){
						if((i+1)%5 == 0){
							if(i%6 == 3){
								if(i%7 == 4){
									if(i%8 == 1){
										if(i%9 == 0){
											System.out.println(i);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
