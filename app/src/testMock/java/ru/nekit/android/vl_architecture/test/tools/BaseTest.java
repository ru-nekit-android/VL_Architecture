package ru.nekit.android.vl_architecture.test.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * Created by ru.nekit.android on 20.04.16.
 */
@RunWith(VLBuildingsTestApplicationRobolectricUnitTestRunner.class)
@Ignore
public abstract class BaseTest {

    @Before
    public abstract void setUp();

    @After
    public abstract void tearDown();
}
