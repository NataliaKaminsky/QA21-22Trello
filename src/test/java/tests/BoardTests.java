package tests;

//import dataproviders.Data;

import dataProviders.DataProviderBoard;
import manager.TestNGListener;

import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNGListener.class)

public class BoardTests extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void login() {
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

    @Test(enabled = false)
    public void createNewBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000) + 1000;
        String boardTitle = "board" + i;
        app.getHelperBoard().createNewBoard(boardTitle);
        logger.info("method --> " + method.getName() + " with data board title --> " + boardTitle);
        //Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(boardTitle));
        Assert.assertTrue(app.getHelperBoard().isTextInElementPresentByWait_boardTitle(boardTitle, 5));
    }

    @Test(enabled = false)
    public void createNewBoardPositiveTest_Lombok(Method method) {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("boardDto" + i)
                .build();
        app.getHelperBoard().createNewBoard(board.getBoardTitle());
        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(board.getBoardTitle()));
    }

    //==================================== dataProvider
    @Test(groups = {"smoke"}, dataProvider = "dataProvider_createNewBoardPositiveTest_DPFile", dataProviderClass = DataProviderBoard.class)
    public void createNewBoardPositiveTest_DP(BoardDTO board, Method method) {
        app.getHelperBoard().createNewBoard(board.getBoardTitle());
        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(board.getBoardTitle()));
    }

    @Test(enabled = false)
    public void deleteBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("boardDto" + i)
                .build();
        app.getHelperBoard().createNewBoard(board.getBoardTitle()); //create new board
        logger.info("start method --> " + method.getName() + " board title --> " + board.getBoardTitle());
        app.getHelperBoard().clickButtonBoards();
        //=================================================
        app.getHelperBoard().deleteBoard(board.getBoardTitle());
    }

    @Test(groups={"smoke"},dataProvider = "dataProvider_deleteBoardPositiveTest_DP", dataProviderClass = DataProviderBoard.class)
    public void deleteBoardPositiveTest_DP(BoardDTO board, Method method) {
        app.getHelperBoard().createNewBoard(board.getBoardTitle()); //create new board
        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
        app.getHelperBoard().clickButtonBoards();
        //=================================================
        app.getHelperBoard().deleteBoard(board.getBoardTitle());
    }

    @Test//(groups = {"smoke"})
    public void deleteAllBoardsTest() {
        //logger.info("start method deleteAllBoards =======================================");
        app.getHelperBoard().deleteElementList();
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.info("start after method ------------------------------");
        if (app.getHelperBoard().isElementPresent_buttonBoards())
            app.getHelperBoard().clickButtonBoards();
        logger.info("stop after method -------------------------------");
    }

    @AfterClass(alwaysRun = true)
    public void logout() {
        logger.info("start after class ------------------------------");
        app.getHelperUser().logout();
        logger.info("stop after class -------------------------------");
    }
}