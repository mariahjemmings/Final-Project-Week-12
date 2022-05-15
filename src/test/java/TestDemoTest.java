import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.*; 


class TestDemoTest {

	
		

		@BeforeEach
		void setUp() throws Exception {
			
			TestDemo testDemo = new TestDemo();
			
		}

		@ParameterizedTest
		@MethodSource("TestDemoTest#argumentsForAddPositive")
		void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
			TestDemo testDemo = new TestDemo();
				
			if(!expectException) {
				  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
				}
			else {
				assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class); 
			}

		}
		
		@Test
		protected void assertThatNumberSquaredIsCorrect() {
			TestDemo testDemo = new TestDemo();
			TestDemo mockDemo = spy(testDemo);
			doReturn(5).when(mockDemo).getRandomInt();
			int fiveSquared = mockDemo.randomNumberSquared();
			assertThat(fiveSquared).isEqualTo(25);
		}
		
		
		static Stream argumentsForAddPositive() {
			TestDemo testDemo = new TestDemo();
			return Stream.of(arguments(2,3,5,false),
			arguments(4,7,11,false),
			arguments(0,0,0,false),
			arguments(-1,-4,-5,true));
		

	}

	
		






}