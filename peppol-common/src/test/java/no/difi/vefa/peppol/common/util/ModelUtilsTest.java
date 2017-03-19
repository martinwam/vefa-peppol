/*
 * Copyright 2016-2017 Direktoratet for forvaltning og IKT
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 */

package no.difi.vefa.peppol.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModelUtilsTest {

    @Test
    public void simpleConstructor() {
        new ModelUtils();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void simpleEncoderNullPointer() {
        ModelUtils.urlencode(null, "Some", "values");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void simpleDecoderNullPointer() {
        ModelUtils.urldecode(null);
    }

    @Test
    public void simple() throws Exception {
        String value = "9908:991825827";

        String encoded = ModelUtils.urlencode(value);
        Assert.assertNotEquals(encoded, value);

        String decoded = ModelUtils.urldecode(encoded);
        Assert.assertEquals(decoded, value);
    }
}
