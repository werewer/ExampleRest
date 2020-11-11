package com.pasha.ExampleRest.repo;

import com.pasha.ExampleRest.entities.Clid;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClidFakeRepository {

    public List<Clid> findAll() {
        return TEST_CLIDS;
    }

    public Clid findById(String clidId) {
        if (clidId == null) return new Clid();
        return TEST_CLIDS.stream().filter(clid -> clidId.equals(clid.getClid())).findFirst().orElse(new Clid());
    }

    private static final List<Clid> TEST_CLIDS = new ArrayList<>(3) {{
        add(new Clid() {{
            setClid("3819203321");
            setAddrId(1L);
        }});

        add(new Clid(){{
            setClid("3623724345");
            setAddrId(1L);
        }});

        add(new Clid(){{
            setClid("5234523424");
            setAddrId(1L);
        }});
    }};
}
