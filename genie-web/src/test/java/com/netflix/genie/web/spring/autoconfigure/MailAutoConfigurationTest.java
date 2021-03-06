/*
 *
 *  Copyright 2018 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.web.spring.autoconfigure;

import com.netflix.genie.web.properties.MailProperties;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Tests for {@link MailAutoConfiguration} configuration.
 *
 * @author tgianos
 * @since 4.0.0
 */
class MailAutoConfigurationTest {

    /**
     * Confirm we can get a default mail service implementation.
     */
    @Test
    void canGetDefaultMailServiceImpl() {
        Assertions.assertThat(new MailAutoConfiguration().getDefaultMailServiceImpl()).isNotNull();
    }

    /**
     * Confirm we can get a mail service implementation using JavaMailSender.
     */
    @Test
    void canGetMailServiceImpl() {
        final JavaMailSender javaMailSender = Mockito.mock(JavaMailSender.class);
        final MailProperties properties = new MailProperties();
        properties.setFromAddress("test@genie.com");
        Assertions.assertThat(
            new MailAutoConfiguration().getJavaMailSenderMailService(javaMailSender, properties)
        ).isNotNull();
    }
}
