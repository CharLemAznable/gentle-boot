package com.github.charlemaznable.gentle.spring.boot;

import com.github.charlemaznable.configservice.ConfigFactory;
import com.google.common.collect.Lists;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.ServiceLoader;

import static com.github.charlemaznable.core.lang.Empty.isEmpty;
import static org.joor.Reflect.onClass;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
            val configProperties = GentleBootConfigLoader.getConfigProperties();
            assertNotNull(configProperties);
            assertTrue(isEmpty(configProperties));
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

    @Test
    public void testDefaultConfig() {
        val reflectConfigFactory = onClass(ConfigFactory.class);
        boolean hasApollo = reflectConfigFactory.get("hasApollo");
        boolean hasDiamond = reflectConfigFactory.get("hasDiamond");
        reflectConfigFactory.set("hasApollo", false);
        reflectConfigFactory.set("hasDiamond", false);

        try (val mockServiceLoader = mockStatic(ServiceLoader.class)) {
            ServiceLoader mockConfigs = mock(ServiceLoader.class);
            when(mockConfigs.iterator()).thenReturn(Lists.newArrayList().iterator());
            mockServiceLoader.when(() -> ServiceLoader.load(GentleBootConfig.class)).thenReturn(mockConfigs);

            GentleBootConfigLoader.loadGentleBootConfig();
            val configProperties = GentleBootConfigLoader.getConfigProperties();
            assertNotNull(configProperties);
            assertTrue(isEmpty(configProperties));
        }

        reflectConfigFactory.set("hasApollo", hasApollo);
        reflectConfigFactory.set("hasDiamond", hasDiamond);
    }
}
