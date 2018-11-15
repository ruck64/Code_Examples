#include "pi.c"
#include <stdexcept>
#include <gtest/gtest.h>

//Precision Tests
///////////////////////////////////////////////////
TEST(PrecisionTests, 0Iterations) {

		ASSERT_DOUBLE_EQ(4, calcPi(0));
}

TEST(PrecisionTests, 5Iterations) {

	 ASSERT_DOUBLE_EQ(2.976045, calcPi(5));

}

TEST(PrecisionTests, 10Iterations) {

	 ASSERT_DOUBLE_EQ(3.23232, calcPi(10));

}

TEST(PrecisionTests, 15Iterations) {

		ASSERT_DOUBLE_EQ(3.07915, calcPi(15));
}

TEST(PrecisionTests, 100Iterations) {

		ASSERT_DOUBLE_EQ(3.15149, calcPi(100));
}

TEST(PrecisionTests, 1000Iterations) {
		ASSERT_DOUBLE_EQ(3.14259, calcPi(1000));
}

/////////////////////////////////////////////////////
int main(int argc, char **argv) {
	testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}


