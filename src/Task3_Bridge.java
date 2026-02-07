package lab3;

// Завдання 3: Міст

interface IRenderer {
    void render(String shapeName);
}

class VectorRenderer implements IRenderer {
    @Override
    public void render(String shapeName) {
        System.out.println("Drawing " + shapeName + " as vector");
    }
}

class RasterRenderer implements IRenderer {
    @Override
    public void render(String shapeName) {
        System.out.println("Drawing " + shapeName + " as pixels");
    }
}

abstract class Shape {
    protected IRenderer renderer;

    public Shape(IRenderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

class Circle extends Shape {
    public Circle(IRenderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Circle");
    }
}

class Square extends Shape {
    public Square(IRenderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Square");
    }
}

class Triangle extends Shape {
    public Triangle(IRenderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Triangle");
    }
}

class Task3 {
    public static void demonstrate() {
        IRenderer vectorRenderer = new VectorRenderer();
        IRenderer rasterRenderer = new RasterRenderer();

        Shape circleVector = new Circle(vectorRenderer);
        Shape circleRaster = new Circle(rasterRenderer);
        Shape squareVector = new Square(vectorRenderer);
        Shape squareRaster = new Square(rasterRenderer);
        Shape triangleVector = new Triangle(vectorRenderer);
        Shape triangleRaster = new Triangle(rasterRenderer);

        circleVector.draw();
        circleRaster.draw();
        squareVector.draw();
        squareRaster.draw();
        triangleVector.draw();
        triangleRaster.draw();
    }
}
