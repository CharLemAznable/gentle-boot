package com.github.charlemaznable.gentle.spring.boot;

import com.google.common.collect.Lists;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.ServiceLoader;

import static com.github.charlemaznable.core.lang.Empty.isEmpty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class GentleBootConfigLoaderTest {

    @Test
    public void testSingleConfig() {
        try (val mockServiceLoader = mockStatic(ServiceLoader.class)) {
            ServiceLoader mockConfigs = mock(ServiceLoader.class);
            when(mockConfigs.iterator()).thenReturn(Lists.newArrayList(
                    (GentleBootConfig) Properties::new).iterator());
            mockServiceLoader.when(() -> ServiceLoader.load(GentleBootConfig.class)).thenReturn(mockConfigs);

            GentleBootConfigLoader.loadGentleBootConfig();
            assertTrue(isEmpty(GentleBootConfigLoader.getConfigProperties()));
        }
    }

    @Test
    public void testMultipleConfig() {
        try (val mockServiceLoader = mockStatic(ServiceLoader.class)) {
            ServiceLoader mockConfigs = mock(ServiceLoader.class);
            when(mockConfigs.iterator()).thenReturn(Lists.newArrayList(
                    (GentleBootConfig) Properties::new, Properties::new).iterator());
            mockServiceLoader.when(() -> ServiceLoader.load(GentleBootConfig.class)).thenReturn(mockConfigs);

            assertThrows(IllegalStateException.class, GentleBootConfigLoader::loadGentleBootConfig);
        }
    }
}
