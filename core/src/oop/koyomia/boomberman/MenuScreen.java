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

    //navigation
    int oldButtonHover;
    int certainButtonHover;
    int certainMainMenuSelection;
    boolean inMainMenu;

    //for animation
    boolean isAnimationRan;
    boolean isUpAnimation;
    int drawx, drawy, draww, drawh;
    int bgx1;
    int bgy = -580;
    int ticks = 0;
    boolean welcomeScreenFinished = true;
//<<<<<<< Updated upstream
//=======
//
//>>>>>>> Stashed changes

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


    /**
     * return the appropriate x value to render text from center of the screen.
     * Requires input.
     *
     * @param bitmapFont : the BitmapFont to render
     * @param value : the string to render
     * @return float : the appropriate x value to render text from center of the screen
     *
     */
    private float getWidthOffset(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return Gdx.graphics.getWidth()* .5f - glyphLayout.width/2;
    }

    /**
     * return the width of rendered text.
     *
     * @param bitmapFont : the BitmapFont to render
     * @param value : the string to render
     * @return float : the width of rendered text
     *
     */
    private float getWidthPixel(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return glyphLayout.width;
    }

    /**
     * return the height of rendered text.
     *
     * @param bitmapFont : the BitmapFont to render
     * @param value : the string to render
     * @return float : the height of rendered text
     *
     */
    private float getHeightPixel(BitmapFont bitmapFont, String value) {
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(bitmapFont, value);
        return glyphLayout.height;
    }
    
    public void configFontEngine(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/EightBitDragon-anqx.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter TitleParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter TextParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        TitleParameter.size = 22;
        title = generator.generateFont(TitleParameter); // font size 12 pixels
        TextParameter.size = 15;
        menutext = generator.generateFont(TextParameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    /**
     * Render welcome screen while welcomeScreenFinished = false.
     * If welcomeScreenFinished = true then no more render welcome screen.
     * Even coming back from Ingame.
     *
     */
    public void welcomeScreenRender(){
        if (ticks < 160) title.draw(game.batch, "Powered by LibGDX & Java SE", getWidthOffset(title, "Powered by LibGDX & Java SE"), Gdx.graphics.getHeight() * .5f);
        else if (ticks > 160 && ticks < 320) title.draw(game.batch, "Koyomia100 presents", getWidthOffset(title, "Koyomia100 Presents"), Gdx.graphics.getHeight() * .5f);
        else if (ticks > 320 && ticks < 400) title.draw(game.batch, "Project Backerman", getWidthOffset(title, MENU_TITLE), Gdx.graphics.getHeight() * .5f);
        else if (ticks > 400) title.draw(game.batch, "Project Backerman", getWidthOffset(title, MENU_TITLE), Gdx.graphics.getHeight() * .5f + ticks-400);
        ticks++;
        bgy++;
        if (ticks == 580) welcomeScreenFinished = true;
    }

    /**
     * Load main background from 3 random backgrounds.
     */
    public void initBackground() {
        Random random = new Random();
        int oneTwoThree = random.nextInt(3) + 1;
        background = new Texture("bg" + oneTwoThree +".png");
        bgx1 = 1;
    }


    public void drawBackground(){
        game.batch.draw(background,bgx1+Gdx.graphics.getWidth(),bgy);
        game.batch.draw(background,bgx1,bgy);
        bgx1--;
        if (bgx1 <= -Gdx.graphics.getWidth()) {
            bgx1 = 0;
        }
    }

    /**
     * Initialize menu button from currentList.
     *
     * All set centered.
     *
     * @param first_y       the y at which it start rendering the button list
     * @param d             distance between buttons in pixel
     * @param buttonHeight  button size
     */
    public void initMenuButton(int first_y, int d, int buttonHeight) {
        int first_yDraft = first_y;

        for (int i = 0; i<currentList.size(); i++){
            String buttonLabelDraft = currentList.get(i).getLabel();

            currentList.get(i).setPosition( (int) getWidthOffset(menutext, buttonLabelDraft), first_yDraft);
            currentList.get(i).setSize( (int) getWidthPixel(menutext, buttonLabelDraft), (int) getHeightPixel(menutext, buttonLabelDraft));

            first_yDraft = first_yDraft - currentList.get(i).getHeight() - d;

            System.out.println("Button called " + currentList.get(i).getLabel() + " | " + currentList.get(i).getWidth() + "x" + currentList.get(i).getHeight()
                    + " | Position spawned: " + currentList.get(i).getX() + " " + currentList.get(i).getY());
        }

    }


    public void drawMenuButtonFill(List<MenuButton> list){
        if (!isAnimationRan) {
                if (!isUpAnimation) {
                    drawy-=3;
                    if (drawy <= list.get(certainButtonHover).getY()-list.get(certainButtonHover).getHeight()-8)
                        isAnimationRan = true;
                }
                else {
                    drawy+=3;
                    if (drawy >= list.get(certainButtonHover).getY()-list.get(certainButtonHover).getHeight()-8)
                        isAnimationRan = true;
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
        drawMenuButtonFill(currentList);
        for (MenuButton certainButton : currentList) {
            if (certainButton.isDisabled) menutext.setColor(Color.GRAY);
            else menutext.setColor(Color.WHITE);
            menutext.draw(game.batch, certainButton.getLabel(), certainButton.getX(), certainButton.getY());
        }
    }

    @Override
    public void show() {
        //config all the screen button render tree
        configMenuButton();

        //config system font
        configFontEngine();

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
        if (!welcomeScreenFinished)
            welcomeScreenRender();
        else {
            title.draw(game.batch, MENU_TITLE, getWidthOffset(title, MENU_TITLE), Gdx.graphics.getHeight() * .75f);
            drawMenuButton();
        }

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
                    if (certainButtonHover < currentList.size()-1){
                        currentList.get(certainButtonHover).setStatus(0);
                        oldButtonHover = certainButtonHover;
                        isAnimationRan = false;
                        isUpAnimation = false;
                        certainButtonHover++;
                        currentList.get(certainButtonHover).setStatus(1);
                    }
                }
                if (keyCode == Input.Keys.UP) {
                    if (certainButtonHover > 0){
                        currentList.get(certainButtonHover).setStatus(0);
                        oldButtonHover = certainButtonHover;
                        isAnimationRan = false;
                        isUpAnimation = true;
                        certainButtonHover--;
                        currentList.get(certainButtonHover).setStatus(1);
                    }
                }
                if (keyCode == Input.Keys.ENTER) {
                    if (inMainMenu){

                        //EXIT BUTTON
                        if (certainButtonHover == currentList.size()-1){
                            System.exit(0);
                        }
                        else if (!currentList.get(certainButtonHover).isDisabled) {
                            certainMainMenuSelection = certainButtonHover;
                            System.out.println(certainMainMenuSelection + " selected");
                            MENU_TITLE = MenuButtonList.get(certainButtonHover).getLabel();
                            inMainMenu = false;
                            constructCurrentList(ActivationList.get(certainMainMenuSelection));
                        }

                    } else {

                        //BACK BUTTON
                        if (certainButtonHover == currentList.size()-1){
                            MENU_TITLE = "Project Backerman";
                            constructCurrentList(MenuButtonList);
                            inMainMenu = true;
                        }

                        //NEW GAME LEVEL
                        else if (certainMainMenuSelection == 0){
                            IngameScreen ingameScreen = new IngameScreen(game);
                            game.setScreen(ingameScreen);
                            Gdx.input.setInputProcessor(ingameScreen);
                        }
                    }
                }
                if (keyCode == Input.Keys.ESCAPE) {
                    if (!inMainMenu) {
                        MENU_TITLE = "Project Backerman";
                        constructCurrentList(MenuButtonList);
                        inMainMenu = true;
                    }
                }
                return true;
            }
        });
    }

    public void constructCurrentList(List<MenuButton> list){
        currentList = list;
        initMenuButton((int) (Gdx.graphics.getHeight() * .5f) + 30, 20,  50);
        certainButtonHover = 0;
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
        MenuButtonList.get(1).setDisabled(true);
        MenuButtonList.add(new MenuButton("Options"));
        MenuButtonList.add(new MenuButton("About"));
        MenuButtonList.add(new MenuButton("Exit"));

        ActivationList = new ArrayList<>() ;
        ActivationList.add(new ArrayList<>());
        ActivationList.get(0).add(new MenuButton("Level 1"));
        ActivationList.get(0).add(new MenuButton("Level 2"));
        ActivationList.get(0).add(new MenuButton("Level 3"));
        ActivationList.get(0).add(new MenuButton("Level 4"));
        ActivationList.get(0).add(new MenuButton("Level 5"));
        ActivationList.get(0).add(new MenuButton("<- Back"));


        ActivationList.add(new ArrayList<MenuButton>());
        ActivationList.get(1).add(new MenuButton("Save 1"));
        ActivationList.get(1).add(new MenuButton("Save 2"));
        ActivationList.get(1).add(new MenuButton("Save 3"));
        ActivationList.get(1).add(new MenuButton("<- Back"));


        ActivationList.add(new ArrayList<>());
        ActivationList.get(2).add(new MenuButton("Sound: ON"));
        ActivationList.get(2).add(new MenuButton("Volume: 100%"));
        ActivationList.get(2).add(new MenuButton("Bach's GF: null"));
        ActivationList.get(2).add(new MenuButton("<- Back"));
        ActivationList.get(2).get(2).setDisabled(true);

        ActivationList.add(new ArrayList<>());
        ActivationList.get(3).add(new MenuButton("Project Backerman Prototype"));
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
