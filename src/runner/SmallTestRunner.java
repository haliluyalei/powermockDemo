package runner;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import demo.mock.finalClass.testFinalClass;
import demo.mock.helloword.testHelloWorld;
import demo.mock.localVariable.testLocalVariable;
import demo.mock.mockConstructors.testConstructor;
import demo.mock.moreVerify.testMoreVerify;
import demo.mock.useMatcher.testAnswer;
import demo.mock.useMatcher.testMatcher;
import demo.mock.useSpies.testSpies;
import demo.mock.useStatic.testStaticClass;
import fixture.category.Small;

@RunWith(Categories.class)
@Categories.IncludeCategory(Small.class)
@Suite.SuiteClasses({testFinalClass.class,testHelloWorld.class,
					testLocalVariable.class,testConstructor.class,
					testMoreVerify.class,testAnswer.class,
					testMatcher.class,testSpies.class,
					testStaticClass.class})
public class SmallTestRunner {

}

