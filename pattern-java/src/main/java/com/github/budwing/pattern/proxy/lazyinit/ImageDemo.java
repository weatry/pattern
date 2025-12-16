package com.github.budwing.pattern.proxy.lazyinit;

// 1. Subject
interface Image {
    void display();
}

// 2. RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // it may be time-consuming
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// 3. Proxy (Virtual Proxy)
class ImageProxy implements Image {
    private String filename;
    private RealImage realImage; // lazy load

    public ImageProxy(String filename) {
        System.out.println("Just save the image name without loading its content");
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            System.out.println("Prepare the content to display");
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// client usage
public class ImageDemo {
    public static void main(String[] args) {
        Image image = new ImageProxy("photo.jpg");
        // RealImage is not created
        image.display(); // load and display for the first time it's invoked
    }
}

