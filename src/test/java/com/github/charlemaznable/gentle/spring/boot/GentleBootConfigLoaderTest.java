package com.github.charlemaznable.gentle.spring.boot;

import com.google.common.collect.Lists;
import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;

import static com.github.charlemaznable.core.lang.Empty.isEmpty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GentleBootConfigLoaderTest {

    @Test
    public void testSingleConfig() {
        new MockUp<ServiceLoader<GentleBootConfig>>(ServiceLoader.class) {
            @Mock
            public Iterator<GentleBootConfig> iterator() {
                return Lists.newArrayList((GentleBootConfig) Properties::new).iterator();
            }
        };
        GentleBootConfigLoader.loadGentleBootConfig();
        assertTrue(isEmpty(GentleBootConfigLoader.getConfigProperties()));
    }

    @Test
    public void testMultipleConfig() {
        new MockUp<ServiceLoader<GentleBootConfig>>(ServiceLoader.class) {
            @Mock
            public Iterator<GentleBootConfig> iterator() {
                return Lists.newArrayList((GentleBootConfig) Properties::new, Properties::new).iterator();
            }
        };
        assertThrows(IllegalStateException.class, GentleBootConfigLoader::loadGentleBootConfig);
    }
}
