package oop.koyomia.boomberman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The type Menu screen.
 */
public class MenuScreen implements Screen {
    GameScene game;
    Texture background;
    BitmapFont title, menutext;

    String MENU_TITLE = "Project Backerman";
    List<MenuButton> currentList;
    List<MenuButton> MenuButtonList;
    List<List<MenuButton>> ActivationList;

    int oldhover;
    int hover;

    int mainMenuSelection;

    boolean inMainMenu;


    //for animation
    boolean isAnimationRan;
    boolean isUpAnimation;
    int drawx, drawy, draww, drawh;
    int bgx1;

    private class MenuButton {
        private String label;
        private int width;
        private int height;
        private int x;
        private int y;

        private int status;
        private boolean isDisabled;

        MenuButton(String t){
            this.label = t;
        }

        public void setPosition(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setDisabled(boolean a){
            this.isDisabled = a;
        }

        public void setSize(int width, int height){
            this.width = width;
            this.height = height;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public String getLabel(){
            return label;
        }

        public void setStatus(int status){
           this.status = status;
        }

        public int getStatus(){
            return this.status;
        }
    }

    public MenuScreen(GameScene game){
        this.game = game;
    }

    private float getWidthOffset(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return Gdx.graphics.getWidth()* .5f - glyphLayout.width/2;
    }

    private float getWidthPixel(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return glyphLayout.width;
    }

    private float getHeightPixel(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return glyphLayout.height;
    }
    
    public void GenerateFontConfiguration(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/EightBitDragon-anqx.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter TitleParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter TextParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        TitleParameter.size = 20;
        title = generator.generateFont(TitleParameter); // font size 12 pixels
        TextParameter.size = 14;
        menutext = generator.generateFont(TextParameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    public void initBackground() {
        Random random = new Random();
        int oneTwoThree = random.nextInt(3) + 1;
        background = new Texture("bg" + oneTwoThree +".png");
        bgx1 = 1;
    }

    public void drawBackground(){
        game.batch.draw(background,bgx1+Gdx.graphics.getWidth(),0);
        game.batch.draw(background,bgx1,0);
        bgx1--;
        if (bgx1 <= 0-Gdx.graphics.getWidth()) {
            bgx1 = 0;
        }
    }

    public void initMenuButton(int first_y, int first_d, int buttonsize_h) {
        int first_yDraft = first_y;
        for (int i = 0; i<currentList.size(); i++){
            String buttonLabelDraft = currentList.get(i).getLabel();

            currentList.get(i).setPosition( (int) getWidthOffset(menutext, buttonLabelDraft), first_yDraft);
            currentList.get(i).setSize( (int) getWidthPixel(menutext, buttonLabelDraft), (int) getHeightPixel(menutext, buttonLabelDraft));

            first_yDraft = first_yDraft - currentList.get(i).getHeight() - first_d;

            System.out.println("Button called " + currentList.get(i).getLabel() + " | " + currentList.get(i).getWidth() + "x" + currentList.get(i).getHeight()
                    + " | Position spawned: " + currentList.get(i).getX() + " " + currentList.get(i).getY());
        }

    }

    public void drawButtonFill(List<MenuButton> list){

        if (isAnimationRan == false) {
                if (isUpAnimation == false) {
                    drawy-=3;
                    if (drawy <= list.get(hover).getY()-list.get(hover).getHeight()-8) {
                        isAnimationRan = true;
                        System.out.println("finished animation");
                    }
                }
                else {
                    drawy+=3;
                    if (drawy >= list.get(hover).getY()-list.get(hover).getHeight()-8) {
                        isAnimationRan = true;
                        System.out.println("finished animation");
                    }
                }
        }

        game.batch.end();
        Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(new Color(Color.DARK_GRAY));
        game.shapeRenderer.rect(drawx,drawy,draww,drawh);
        game.shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        game.batch.begin();

    }

    public void drawMenuButton(){
            drawButtonFill(currentList);
            for (int i = 0; i<currentList.size(); i++){
                MenuButton certainButton = currentList.get(i);
                menutext.draw(game.batch, certainButton.getLabel(), certainButton.getX(), certainButton.getY());
            }
    }

    @Override
    public void show() {//Stage should control input:
        configMenuButton();
        GenerateFontConfiguration();

        //make this main menu
        constructCurrentList(MenuButtonList);
        inMainMenu = true;

        initBackground();
        isAnimationRan = true;

        setKeyAction();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        drawBackground();
        title.draw(game.batch, MENU_TITLE, getWidthOffset(title, MENU_TITLE), Gdx.graphics.getHeight() * .75f);
        drawMenuButton();
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        game.shapeRenderer.dispose();
    }

    public void setKeyAction(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.DOWN) {
                    if (hover < currentList.size()-1){
                        currentList.get(hover).setStatus(0);
                        oldhover = hover;
                        isAnimationRan = false;
                        isUpAnimation = false;
                        hover++;
                        currentList.get(hover).setStatus(1);
                    }
                }
                if (keyCode == Input.Keys.UP) {
                    if (hover > 0){
                        currentList.get(hover).setStatus(0);
                        oldhover = hover;
                        isAnimationRan = false;
                        isUpAnimation = true;
                        hover--;
                        currentList.get(hover).setStatus(1);
                    }
                }
                if (keyCode == Input.Keys.ENTER) {
                    if (inMainMenu == true){

                        //EXIT BUTTON
                        if (hover == currentList.size()-1){
                            System.exit(0);
                        }

                        //ELSE
                        mainMenuSelection = hover;
                        System.out.println(mainMenuSelection + " selected");
                        MENU_TITLE = MenuButtonList.get(hover).getLabel();
                        inMainMenu = false;
                        constructCurrentList(ActivationList.get(mainMenuSelection));

                    } else {

                        //BACK BUTTON
                        if (hover == currentList.size()-1){
                            MENU_TITLE = "Project Backerman";
                            constructCurrentList(MenuButtonList);
                            inMainMenu = true;
                        }
                    }
                }
                return true;
            }
        });
    }

    public void constructCurrentList(List<MenuButton> list){
        currentList = list;
        initMenuButton((int) (Gdx.graphics.getHeight() * .5f), 20,  50);
        hover = 0;
        drawx = currentList.get(0).getX() - 25;
        drawy = currentList.get(0).getY() - currentList.get(0).getHeight() - 8;
        draww = currentList.get(0).getWidth() + 50;
        drawh = currentList.get(0).getHeight() + 16;
    }

    public void configMenuButton(){
        currentList = new ArrayList<>();

        MenuButtonList = new ArrayList<>() ;
        MenuButtonList.add(new MenuButton("New Game"));
        MenuButtonList.add(new MenuButton("Continue"));
        MenuButtonList.add(new MenuButton("Options"));
        MenuButtonList.add(new MenuButton("About"));
        MenuButtonList.add(new MenuButton("Exit"));

        ActivationList = new ArrayList<>() ;
        ActivationList.add(new ArrayList<MenuButton>());
        ActivationList.get(0).add(new MenuButton("Level 1"));
        ActivationList.get(0).add(new MenuButton("Level 2"));
        ActivationList.get(0).add(new MenuButton("Level 3"));
        ActivationList.get(0).add(new MenuButton("Level 4"));
        ActivationList.get(0).add(new MenuButton("Level 5"));


        ActivationList.add(new ArrayList<MenuButton>());
        ActivationList.get(1).add(new MenuButton("Save 1"));
        ActivationList.get(1).add(new MenuButton("Save 2"));
        ActivationList.get(1).add(new MenuButton("Save 3"));
        ActivationList.get(1).add(new MenuButton("<- Back"));

        ActivationList.add(new ArrayList<MenuButton>());
        ActivationList.get(2).add(new MenuButton("Nothing to config"));
        ActivationList.get(2).add(new MenuButton("<- Back"));

        ActivationList.add(new ArrayList<MenuButton>());
        ActivationList.get(3).add(new MenuButton("Project Backerman"));
        ActivationList.get(3).add(new MenuButton("Made by Koyomia100"));
        ActivationList.get(3).add(new MenuButton(" - "));
        ActivationList.get(3).add(new MenuButton("featuring"));
        ActivationList.get(3).add(new MenuButton("Nguyen Viet Anh"));
        ActivationList.get(3).add(new MenuButton("Tran Xuan Bach"));
        ActivationList.get(3).add(new MenuButton(" - "));
        ActivationList.get(3).add(new MenuButton("VNU-UET, 2020"));
        ActivationList.get(3).add(new MenuButton("<- Back"));

    }
}
