.. include:: variables.inc

|project_name| Scope
***********************
The scope of the |project_name| includes the meta layers:

 * `meta-freescale <http://git.yoctoproject.org/cgit/cgit.cgi/meta-freescale/?h=pyro>`_:
   provides the base support and Freescale ARM and PPC reference boards;
 * `meta-freescale-3rdparty <https://github.com/Freescale/meta-freescale-3rdparty/tree/pyro>`_:
   provides support for 3rd party and partner boards;
 * `meta-freescale-distro <https://github.com/Freescale/meta-freescale-distro/tree/pyro>`_:
   provides distros support, images recipes, demo recipes, and packagegroups
   used to ease the development with Yocto Project.
 * `Documentation <https://github.com/Freescale/Documentation/tree/pyro>`_:
   provides the source code for |project_name| Release Notes (RN) and User Guide
   (UG).

Meta-freescale
==============

Since the Yocto Project release 2.2 (Morty) the |project_name| changed the meta
layers names. You can see the announcement
`here <https://lists.yoctoproject.org/pipermail/meta-freescale/2016-October/019429.html>`_.

The following table show the renaming upgrade path:

================== ======================
Krogoth            Morty
================== ======================
meta-fsl-arm       meta-freescale
meta-fsl-ppc       meta-freescale
meta-fsl-arm-extra meta-freescale-3rdparty
meta-fsl-demos     meta-freescale-distros
================== ======================

The **meta-fsl-arm** and **meta-fsl-ppc** meta layers are deprecated. The last
release for these meta layers is **krogoth**. Do not expect any update to the
layer other than critical bug-fixes. **Meta-fsl-arm** and **meta-fsl-ppc** must
be replaced by **meta-freescale**.

The **meta-freescale** meta layer goal is to integrate the ARM and PPC SoC
based source code from Freescale, it includes **i.MX**, **Vybrid**, **QorIQ**
and **Layerscape** BSPs.

The **meta-fsl-arm-extra** now is **meta-freescale-3rdparty**, any local copy
should work as there is a mirror set.

The **meta-fsl-demos** now is **meta-freescale-distros**, any local copy
should work as there is a mirror set.

License
=======

The |project_name| is a project with the same licensing of most Yocto Project
layers. It means the recipe file is under a certain license, and the source code
used by that recipe is under another certain license (being it equal or not).

Most of |project_name|'s metadata is under MIT license, however the extensive
and accurate list of package's license provided by the Yocto Project's metadata
can be generated with few commands, for detailed information on how license is
handled by Yocto Project see the `Reference Manual
<http://www.yoctoproject.org/docs/2.3/ref-manual/ref-manual.html#licenses>`_.

End User License Agreement (EULA)
---------------------------------

Freescale releases basically two kind of packages, the open sourced packages use
regular open source licenses (GPLv2 for example).

The close sourced packages are released under the Freescale License (known as
EULA). Each package has a copy of EULA inside itself and a copy of the EULA text
is also included inside **meta-freescale** root dir
(``sources/meta-freescale/EULA``).

The |project_name| handles the EULA acceptance by prompting user to read and
accept EULA text at the very first environment setup. It is user's duty to read
and understand it before accepting it. After it is accepted the first time, it
is assumed accepted in any other build.

.. _kernel_release_notes:

Kernel Release Notes
====================
The |project_name| includes support for several kernel providers. Each machine
may have a different Linux Kernel provider.

The |project_name| is not responsible for the content of those kernels.
Although we *as community* should feel empowered to submit bug fixes and new
features for those projects.

See the respective Linux Kernel provider for your machine in section
:ref:`linux-providers`.

Different Product SoC Families
==============================
Currently, the |project_name| includes the following Product SoC Families:

 * **i.MX Application Processors (imx)**: Regarding the `i.MX Freescale Page
   <http://www.freescale.com/webapp/sps/site/homepage.jsp?code=IMX_HOME>`_:
   *i.MX applications processors are multicore ARM??-based solutions for
   multimedia and display applications with scalability, high performance, and
   low power capabilities.*

 * **Vybrid Controller Solutions based on ARM?? Cores (vybrid)**: Regarding the
   `Vybrid Freescale Page <http://www.freescale.com/webapp/sps/site/homepage.jsp?code=VYBRID>`_:
   *Vybrid controller solutions are built on an asymmetrical-multiprocessing
   architecture using ARM?? cores as the anchor for the platform, and are ideal
   for many industrial applications.*

 * **Layerscape Architecture (ls)**: Regarding the `Layerscape Freescale Page
   <http://www.freescale.com/webapp/sps/site/overview.jsp?code=QORIQ_LAYERSCAPE>`_:
   *delivers unprecedented efficiency and scale for the smarter, more capable
   networks of tomorrow.*

Freescale groups a set of SoCs which target different markets in product
families. Those are grouped according to their SoC features and internal
hardware capabilities.

The Yocto Project's tools have the required capabilities to differentiate the
architectures and BSP components for the different SoC families. In this
perspective, the |project_name| can support a wide range of architectures and
product lines which go across several markets.

For the |project_name|, the different SoCs, from all product lines manufactured
by Freescale, can be seen as different machines, thus easing the use of same
architecture across different markets.

.. _supported-boards:

Supported Board List
====================
Please, see the next table for the complete supported board list.

.. tabularcolumns:: c | p{5cm} | c | c
.. table:: Supported machines in |project_name|

   .. include:: machine-list.inc

Machine Maintainers
-------------------

Since |project_name| Release 1.6 (Daisy), the maintainer field in machine
configuration files of **meta-freescale** and **meta-freescale-3rdparty**
is mandatory for any new board to be added.

So now on, every new board must have someone assigned as maintainer.
This ensures, in long term, all boards with a maintainer assigned.
Current orphan boards are not going to be removed unless it causes maintenance
problem and the fix is not straightforward.

The maintainer duties:
 * The one with casting vote when a deadlock is faced.
 * Responsible to keep that machine working (that means, booting and with some
   stability) Keep kernel, u-boot updated/tested/working.
 * Keep release notes updated
 * Keep test cycle updated
 * Keep the most usual images building and booting

When a build error is detected, the maintainer will "fix" it. For those
maintainers with kernel control (meta-freescale-3rdparty), it is expected that they
properly fix the kernel issue (when it's a kernel issue). However, anything out
of community control should be worked around anyway.

Machines with maintainers
^^^^^^^^^^^^^^^^^^^^^^^^^

.. tabularcolumns:: l | p{9cm}
.. table:: Machines with maintainers

   .. include:: machines-with-maintainers.inc

Machines without a maintainer
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. tabularcolumns:: l | p{9cm}
.. table:: Machines without a maintainer

   .. include:: machines-without-maintainers.inc
