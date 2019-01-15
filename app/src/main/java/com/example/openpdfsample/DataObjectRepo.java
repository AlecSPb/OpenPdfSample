package com.example.openpdfsample;

import java.util.HashMap;
import java.util.Map;

public class DataObjectRepo {

    public Map<String, String> GetData(){

        Map<String, String> data = new HashMap<>();

        data.put("Key1","Данные 1");
        data.put("Key2","Данные 2");
        data.put("Key3", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4QEOARwS2H96JgAAA1tJREFUaN7Vl89rHDcUx79P0kgbe9ftukltFxtS2ItJbw4kFxdKoRSCIRfnHJpL+pcEWkJpe8ohB5OSQ84+5W9oD4HszYSEQEtNExK23vXM6On14PGyP2brHrxUGhBivjOM9Jn3fU8SkPhF8/rwkytXmn2iRwD2bz9//nBe46h5fbhP9A2AmwB++KXTWUoOAMCdqm+xc7eSAniwtfUBgM9O74VoOykAV5ZXASgZEsj1pABIZBMANm7cwPH6OkDU+anTcckACLChncOX9+5h++5dCKDazm2kE4EQ1jnP0d3bw6v9fRAAT/TpPMYyc4pAGwB+vX9/RJSP0imjRBemJKWW0gEAFqbDIskDtFICuDA9UkoWqsuBpCwkktdUppCShd7XRCVPaSWeBgihSGclJnpfA5UQgEidhY7TsZDI5Rr5w+jPxA+2tjKX598C+LHm8SGLfHWn230WJcDPm5uPW1p/AWD1jFf/gsj3t7vd76Ky0EG//7UXWf0Pr14UYDm6HMhD0PgfrnM5D+zs7FwMBwfmeHkZmdYgpaCIoJQCnfanmtbI2u01dLvxAGSNxnZ+7drC69VVOOfgrD3pnYMd7a1Fo9FA07nPsbcX0YmM+eOiKNDr9VDkOXJrYa1FVoHYLIOtNOccBouLcVloMBhsFEUBX5bIsmysGWNgrYUxBpm1yIxBs9lcjgpAa/3bwuIiVlZWhtaps5FzDg3n0Gq1XkYF4L1HCAHMDPYerDW81tDMw3aqszEIIUhUAMw8nPzoxEd11hrMDM+M0ntECeBnTHwUypzocUVgLAozJj7UvUdZlpFFABjLgX+zUek9PHNcEcj6/Z4MBn+8efcOWikopWCMKTRRrpSC0hqmWo0zrZFZ+3tcFgrhEwHWRCmEaovL3gNKQUKAhABUYMIMLstzOxucy2ZORC6Hk36shYn7YQMu7e7u2pgA2jMnXoFNwNDS0dFaPNtp5qaIYGYUJvRKuxQNQBBpnPHHpzQWcdEAMFDKLL9PgI0AZDHlQHGmZSZ0hJDFU0ZF8iACGv3jRJjSqjyhE5h+PDkAvD2rfE5GgZT6O6ZD/eEs39fCAAjMvZjK6OGsyUpNaRURaKX+jCYHBHgNkRdCNGYZEskh0hcioNKUCCSE4tHTp0fnMfY/tBHc87AEx4sAAAAASUVORK5CYII=");

        return  data;
    }

}
