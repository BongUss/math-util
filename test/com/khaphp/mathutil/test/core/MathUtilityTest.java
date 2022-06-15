
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaphp.mathutil.test.core;

import com.khaphp.mathutil.core.MathUtil;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author LENOVO
 */
public class MathUtilityTest {

    //đây là class sẽ sử dụng các hàm của thư viện/framework để kiểm tra code chính - hàm tínhgiaithừa() bên 
    //class core.MathUtil
    //viết code để test code
    //có nhiểu quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ nói lên mục đích của các case/tình huống kiểm thử
    //tình xuống xài hàm theo kiểu thành công và thất bại
    //hàm dưới đay là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well- đưa 5!, 6!, hok chơi đưa -5, 30!
    //@Test JUnit sẽ phối hợp vs JVMM để chay hàm này
    //@Test phía hậu trường chính là public static void main
    //có nhiểu @Test ừng vs nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFacctorialGivenRightArgumentReturnsWell() {
        int n = 0;  //test thừ tình huống tử tế đầu vào và m phải chạy đúng
        long expected = 1;  //hy vọng 0! = 1

        //long actual = ; //gọi hàm cần test bên core/app chính/code chính
        long actual = MathUtil.getFactorial(n);

        //so sánh expected vs actual dùng xanh xanh đỏ đỏ, framwork
        Assert.assertEquals(expected, actual);

        //gộp thê vài case thành công nữa/đầu vào ngon
        Assert.assertEquals(1, MathUtil.getFactorial(1));  //tui mún 1! = 1
        Assert.assertEquals(2, MathUtil.getFactorial(2));  //tui mún 2! = 2
        Assert.assertEquals(6, MathUtil.getFactorial(3));  //tui mún 3! = 6
        Assert.assertEquals(24, MathUtil.getFactorial(4));  //tui mún 4! = 24
        Assert.assertEquals(120, MathUtil.getFactorial(5));  //tui mún 5! = 120
        Assert.assertEquals(720, MathUtil.getFactorial(6));  //tui mún 6! = 720

        //hàm giúp sosanh 2 vaue nào đó giống nhau hay ko
        //nếu giống nhau -> thày màu xanh đèn đường - đường thông, code ngon
        //                  ít nhất cho casedang9 test
        //nếu ko giống nhau -> thẩy màu đỏ đèn đường
        //                  hàm ý expected và actual ko giống nhau
    }

    // hàm getF() ta thiết kế có 2 tình huống xử lí
    //1. đưa dât tử tế trong [0..20] -> tính đúng đc n! - done
    //2. đưa data vào cà chớn, âm, >20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với n cà chớn này
    //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> XANH PHẢI XUẤT HIỆN
    //NẾU HÀM NHẬN VÀO N < 0 hoặc N > 20 và hàm éo ném ra ngoại lệ
    //sure, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐỎ
    //Test case:
    //input: -5
    //expected: IllegalArgumentException xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    //là những t hứ không thể đo lượng = cách chúng có xuất hiện hay không
    //assertEquals() không dùng để so sánh 2 ngoại lệ
    // equals() là bằng nhau hay không trên value!!!
    //MÀU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẬT SỰ
    //              NHƯNG KO PHẢI LÀ NGOẠI LỆ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI
    //              KO PHẢI HÀM NÉM SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFacctorialGivenWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
//                                   //sẽ ném về ngoại lệ NumberFormat
//        
//    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetFacctorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5); //hàm @Test chạy, hay hàm getF() chạy
        //sẽ ném về ngoại lệ NumberFormat

    }

    //còn cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //xài Lambda
    //Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    // tui cần thấy màu xanh khi chơi với 21!
    @Test(expected = IllegalArgumentException.class)
    public void testGetFacctorialGivenWrongArgumentThrowsException_LambdaVersion() {

//        Assert.assertThrows(IllegalArgumentException.class,
//                () -> MathUtil.getFactorial(-5));
        MathUtil.getFactorial(-5);
    }

    //Bắt ngoại lệ, xem hàm có ném ngoại lệ hay hông khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFacctorialGivenWrongArgumentThrowsException_TryCatch() {
        try {
            MathUtil.getFactorial(-5);

        } catch (Exception e) {
            //bắt try-catch là junit sẽ ra màu xanh, do đã chủ động kiểm soát ngoại lệ,
            //nhưng không chắc ngoại lệ mình cần có xuất hiện hya ko???
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException
            Assert.assertEquals("Invalid argument, N must be between 0..20 haha", e.getMessage());

        }
    }
}
