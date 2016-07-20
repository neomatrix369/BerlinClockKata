Berlin Clock Kata
=================

Create a representation of the Berlin Clock for a given time (hh::mm:ss).

The Berlin Uhr (Clock) is a rather strange way to show the time.

On the top of the clock there is a yellow lamp that blinks on/off every two seconds.

The time is calculated by adding rectangular lamps.

Top of the clock - [Y] or [O]

The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps.
Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour.
So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

```
L -------------------------------> R
  [R][R][R][R]
   5h 5h 5h 5h
  [R][R][R][R]
   1h 1h 1h 1h
L -------------------------------> R
```

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4.
In the first row every lamp represents 5 minutes.
In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.

The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

```
L -------------------------------> R
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
   5m 5m 5m 5m 5m 5m 5m 5m 5m 5m 5m
  [Y][Y][Y][Y]
   1m 1m 1m 1m
L -------------------------------> R
```

The lamps are switched on from left to right.
```
Y = Yellow
R = Red
O = Off
```

```

[Y] [O] [Y] [O] [Y] [O] [Y] [O] [Y] [O] ...
 1s  2s  1s  2s  1s  2s  1s  2s  1s  2s ...
L -------------------------------> R
  [R][R][R][R]
   5h 5h 5h 5h
  [R][R][R][R]
   1h 1h 1h 1h
L -------------------------------> R
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
   5m 5m 5m 5m 5m 5m 5m 5m 5m 5m 5m
  [Y][Y][Y][Y]
   1m 1m 1m 1m
L -------------------------------> R

```

Not clear if the last row of lamps (4th row) are [R] or [Y]? If we use deduction it might be [Y] instead of [R].

List of times to convert from 24 hours to Berlin clock:
```
00:00
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
00:01
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [Y]      [O]      [O]      [O]
```
```
00:04
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [Y]      [Y]      [Y]      [Y]
```
```
00:15
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [Y][Y][R][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
00:30
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
00:45
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][O][O]
  [O]      [O]      [O]      [O]
```
```
00:59
  [O]      [O]      [O]      [O]
  [O]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
  [Y]      [Y]      [Y]      [Y]
```
```
01:10
  [O]      [O]      [O]      [O]
  [R]      [O]      [O]      [O]
  [Y][Y][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
02:30
  [O]      [O]      [O]      [O]
  [R]      [R]      [O]      [O]
  [Y][Y][R][Y][Y][R][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
03:00
  [O]      [O]      [O]      [O]
  [R]      [R]      [R]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
03:15
  [O]      [O]      [O]      [O]
  [R]      [R]      [R]      [O]
  [Y][Y][R][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
04:25
  [O]      [O]      [O]      [O]
  [R]      [R]      [R]      [R]
  [Y][Y][R][Y][Y][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
06:00
  [R]      [O]      [O]      [O]
  [R]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
06:45
  [R]      [O]      [O]      [O]
  [R]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][O][O]
  [O]      [O]      [O]      [O]
```
```
09:00
  [R]      [O]      [O]      [O]
  [R]      [R]      [R]      [R]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
09:34
  [R]      [O]      [O]      [O]
  [R]      [R]      [R]      [R]
  [Y][Y][R][Y][Y][R][O][O][O][O][O]
  [Y]      [Y]      [Y]      [Y]
```
```
11:59
  [R]      [R]      [O]      [O]
  [R]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
  [Y]      [Y]      [Y]      [Y]
```
```
12:00
  [R]      [R]      [O]      [O]
  [R]      [R]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
12:30
  [R]      [R]      [O]      [O]
  [R]      [R]      [O]      [O]
  [Y][Y][R][Y][Y][R][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
15:00
  [R]      [R]      [R]      [O]
  [O]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
15:30
  [R]      [R]      [R]      [O]
  [O]      [O]      [O]      [O]
  [Y][Y][R][Y][Y][R][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
18:00
  [R]      [R]      [R]      [O]
  [R]      [R]      [R]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
21:00
  [R]      [R]      [R]      [R]
  [R]      [O]      [O]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
21:17
  [R]      [R]      [R]      [R]
  [R]      [O]      [O]      [O]
  [Y][Y][R][O][O][O][O][O][O][O][O]
  [Y]      [Y]      [O]      [O]
```
```
23:00
  [R]      [R]      [R]      [R]
  [R]      [R]      [R]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [O]      [O]      [O]      [O]
```
```
23:04
  [R]      [R]      [R]      [R]
  [R]      [R]      [R]      [O]
  [O][O][O][O][O][O][O][O][O][O][O]
  [Y]      [Y]      [Y]      [Y]
```
```
23:55
  [R]      [R]      [R]      [R]
  [R]      [R]      [R]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
  [O]      [O]      [O]      [O]
```
```
23:59
  [R]      [R]      [R]      [R]
  [R]      [R]      [R]      [O]
  [Y][Y][R][Y][Y][R][Y][Y][R][Y][Y]
  [Y]      [Y]      [Y]      [Y]
```
