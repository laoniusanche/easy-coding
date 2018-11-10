package com.luhanlin.easycoding.Chapter08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2018/11/11 1:53 AM
 */
public class CoverageSimpleMethodsTest {

    @Test
    @DisplayName(" line coverage simple test")
    void testLineCoverageSimple(){
        CoverageSimpleMethods coverageSimpleMethods = new CoverageSimpleMethods();
        Assertions.assertTrue(coverageSimpleMethods.testMethod(1, 2, 0));
    }

    @ParameterizedTest
    @DisplayName(" condition decision coverage simple test result true")
    @CsvSource({
            "1, 2, 0",
            "1, 0, 3",
            "0, 0, 3",
            "1, 0, 2"
    })
    void testConditionDecisionCoverageTrue(int a, int b, int c){
        CoverageSimpleMethods coverageSimpleMethods = new CoverageSimpleMethods();
        Assertions.assertTrue(coverageSimpleMethods.testMethod(a, b, c));
    }


}
