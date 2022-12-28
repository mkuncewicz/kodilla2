package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperSuiteTest {

    private final TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void TrelloDomainToDto(){
        //Given
        TrelloCard trelloCard = new TrelloCard("testName1","testDes1","testPos1","testIdList1");

        TrelloList trelloList = new TrelloList("testId3","testName3",false);
        List<TrelloList> testTrelloList = new ArrayList<>();
        testTrelloList.add(trelloList);
        testTrelloList.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("testId2","testName2",testTrelloList);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(trelloCard);
        List<TrelloListDto> listDto = trelloMapper.mapToListDto(testTrelloList);
        List<TrelloBoardDto> boardListDto = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals("testName1",cardDto.getName());
        assertEquals(2,listDto.size());
        assertEquals(1,boardListDto.size());

        System.out.println("Lists:");
        for (TrelloListDto list : listDto){
            System.out.println("ID: "+ list.getId() + " Name: " + list.getName());
        }
        System.out.println("\nBoards:");
        for (TrelloBoardDto board : boardListDto){
            System.out.println("ID: "+ board.getId()+ " Name: " + board.getName());
        }
    }

    @Test
    void TrelloDtoToDomain(){

        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testName1","testDes1","testPos1","testIdList1");

        TrelloListDto trelloListDto = new TrelloListDto("testId3","testName3",true);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto);
        trelloListDtoList.add(trelloListDto);
        trelloListDtoList.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("testId4","testName4",trelloListDtoList);
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtoList);
        List<TrelloBoard> trelloBoardsList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals("testDes1",trelloCard.getDescription());
        assertEquals(3,trelloLists.size());
        assertEquals(2,trelloBoardsList.size());

        System.out.println("Lists:");
        for (TrelloList list : trelloLists){
            System.out.println("ID: "+ list.getId() + " Name: " + list.getName());
        }
        System.out.println("\nBoards:");
        for (TrelloBoard board : trelloBoardsList){
            System.out.println("ID: "+ board.getId()+ " Name: " + board.getName());
        }
    }
}
