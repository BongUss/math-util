/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaphp.mathutil.core;

/**
 *
 * @author LENOVO
 */
public class MathUtil {
            //trong class này cung cấp cho ai đó nhiểu hàm xử lý toán học
        //clone class Math của JDK
        //hàm thư viện xài chung cho ai đó mà ko cần lưu lại giá trị thì 
        //chọn thiết kế là hàm static
            
        //hàm tính gia thừa!!!
        //n! = 1.2.3.4...n
        //ko có gia thừa âm
        //0! = 1! = 1 quy ước
        //giai thừa hàm đồ thị dốc đứng , tăng nhanh về giá trị
        //20 giai thừa 18 con số 0, vừa kịp đủ cho kiễu long của java
        //21 gia hừa tràn kiểu long
        //bài nay quy ước tính n! trong khoảng 1..20
//        public static long getFactorial(int n){
//            if(n < 0 || n > 20){
//                throw new IllegalArgumentException("Invalid argument, N must be between 0..20");
//            }
//            
//            if(n == 0 || n == 1)
//                return 1;   //kết thúc cuộc chơi sớm nếu nhận đc giá trị đặc biệt
//            
//            long product = 1;   //tích  nhân dồn, thuật toán con heo đất, ốc bưu dồn thịt
//            for (int i = 2; i <= n; i++)
//                product *= i;
//            
//            return product;
//        }
        
        //hoc de quy trong 30s
        //de quy la goi lai chinh minh voi 1 quy mo khac
        //Vi du: con bupbe Nga, giong nhau va long trong nhau
        //bup be to, nho hon, nho hon nua... den diem dung
        
        //tinh gium tui 6!
        //n! = 1.2.3.4.5..... .n
        //6! = 6 x 5!
        //5! = 5 x 4!
        //4! = 4 x 3!
        //3! = 3 x 2!
        //2! = 2 x 1!
        //1! = 1
        
        //
        
              public static long getFactorial(int n){
            if(n < 0 || n > 20){
                throw new IllegalArgumentException("Invalid argument, N must be between 0..20");
            }
            
            if(n == 0 || n == 1)
                return 1;   //kết thúc cuộc chơi sớm nếu nhận đc giá trị đặc biệt
            
            return n * getFactorial(n -1);
        }
}
