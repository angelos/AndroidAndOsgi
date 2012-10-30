What's this?
========

This repository contains the demo material the "Android and OSGi" talk given at JFall, 2012-10-31. The numbers in the project names refer to marked examples in the slidedeck.

How do I play with this?
=========
Tools
--------
I used,

- Eclipse 4.2
- Android Toolkit 20 (?)
- BNDTools 1.0

Playing with the project
--------

The repository contains an Eclipse workspace. Clone it, point your Eclipse to it (use the directory as a workspace), and import the projects using `File -> Import... -> Existing Projects into Workspace`.

You can now run every project that is an Android project; the other project projects with the same number prefix are projects that contain BNDTools bundles.

Anything I should know?
==========

Some examples are broken!
-------
That's the point, read the slidedeck :)

Eclipse doesn't pick up the changes to my bundle!
-------
True. I use symlinks to get the examples into the Android project; Eclipse cannot pick up those changes, and you should refresh the Android project.

I'm on Windows, and I find this offensive.
-----
Yes, I do use symlinks quite a lot, and those don't work on Windows. Sorry about that.