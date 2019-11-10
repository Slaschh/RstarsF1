package com.rstarschampionship.RstarsF1.services;

import com.rstarschampionship.RstarsF1.entity.Pilote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PiloteServiceTest
{
    @Autowired
    private PiloteService piloteService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords()
    {
        List<Pilote> pilotes = piloteService.list();

        Assert.assertEquals(pilotes.size(),3);
    }
}
