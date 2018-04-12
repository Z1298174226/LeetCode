package com.zhao.lex.leetcode.microsoft;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by qtfs on 2018/4/9.
 */
public class Streams  {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }

        public static void main(String[] args) {
            final Collection< Task > tasks = Arrays.asList(
                    new Task( Status.OPEN, 5 ),
                    new Task( Status.OPEN, 13 ),
                    new Task( Status.CLOSED, 8 )
            );
            final long totalPointsOfOpenTasks = tasks
                    .stream()
                    .filter( task -> task.getStatus() == Status.OPEN )
                    .mapToInt( Task::getPoints )
                    .sum();

            System.out.println( "Total points: " + totalPointsOfOpenTasks );
        }

    }
}