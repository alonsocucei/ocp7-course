package topic_8_6;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * - WatchService allows you to be notified for changes in a Path.
 * - To get a WatchService use the newWatchService() method from FileSystem class.
 * - To register a Path to be watched use the register() method of Path interface.
 * - To wait for an event call the take() or poll() methods from WatchService.
 * - Use the WatchKey interface to save the events.
 * - Finally use the WhatKey.Kind interface to check what kind of event happened.
 * - Events are declared in StandardWatchEventKinds class.
 */
public class TestWatchService {
    public static void main(String[] args) {
        Path desktop = Paths.get("C:\\Users\\jjsanche\\Desktop");
        
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            desktop.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY, 
                    StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

            WatchKey key;

            while(true) {
                key = watcher.take();
                
                for(WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    System.out.printf("event kind name: %s\n", kind.name());
                    System.out.printf("event kind type: %s\n", kind.type());
                    System.out.printf("event count: %s\n", event.count());
                    System.out.printf("event context: %s\n", event.context());
                }
                
                key.reset(); //if ommitted then no more events are watched
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What's the difference between take() and poll() methods of WatchService?
 * - How could subdirectories be watched?
 */