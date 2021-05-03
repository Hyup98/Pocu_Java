package academy.pocu.comp2500.assignment2.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static String ASSIGNMENT2_PACKAGE_NAME = "academy.pocu.comp2500.assignment2";
    protected static final int TOTAL_INTERFACES_COUNT = 55;

    protected HashMap<InterfaceKey, Interface> interfaces = new HashMap<>();

    public final HashMap<InterfaceKey, Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerRedStampCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_RED_INK, new Interface(className));
    }

    public final void registerRedStampCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_RED_INK, new Interface(className, methodName));
    }

    public final void registerBlueStampCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_BLUE_INK, new Interface(className));
    }

    public final void registerBlueStampCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_BLUE_INK, new Interface(className, methodName));
    }

    public final void registerGreenStampCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_GREEN_INK, new Interface(className));
    }

    public final void registerGreenStampCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_STAMP_WITH_GREEN_INK, new Interface(className, methodName));
    }

    public final void registerWallCalendarCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_WALL_CALENDAR, new Interface(className));
    }

    public final void registerWallCalendarCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_WALL_CALENDAR, new Interface(className, methodName));
    }

    public final void registerMagnetCalendarCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_MAGNET_CALENDAR, new Interface(className));
    }

    public final void registerMagnetCalendarCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_MAGNET_CALENDAR, new Interface(className, methodName));
    }

    public final void registerDeskCalendarCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_DESK_CALENDAR, new Interface(className));
    }

    public final void registerDeskCalendarCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_DESK_CALENDAR, new Interface(className, methodName));
    }

    public final void registerLandscapeBannerCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_LANDSCAPE_BANNER, new Interface(className));
    }

    public final void registerLandscapeBannerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_LANDSCAPE_BANNER, new Interface(className, methodName));
    }

    public final void registerPortraitBannerCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_PORTRAIT_BANNER, new Interface(className));
    }

    public final void registerPortraitBannerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_PORTRAIT_BANNER, new Interface(className, methodName));
    }

    public final void registerGlossBannerCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_GLOSS_BANNER, new Interface(className));
    }

    public final void registerGlossBannerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_GLOSS_BANNER, new Interface(className, methodName));
    }

    public final void registerScrimBannerCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_SCRIM_BANNER, new Interface(className));
    }

    public final void registerScrimBannerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_SCRIM_BANNER, new Interface(className, methodName));
    }

    public final void registerMeshBannerCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_MESH_BANNER, new Interface(className));
    }

    public final void registerMeshBannerCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_MESH_BANNER, new Interface(className, methodName));
    }

    public final void registerLandscapeBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_LANDSCAPE_BUSINESS_CARD, new Interface(className));
    }

    public final void registerLandscapeBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_LANDSCAPE_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerPortraitBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_PORTRAIT_BUSINESS_CARD, new Interface(className));
    }

    public final void registerPortraitBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_PORTRAIT_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerIvoryBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_IVORY_BUSINESS_CARD, new Interface(className));
    }

    public final void registerIvoryBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_IVORY_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerGrayBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_GRAY_BUSINESS_CARD, new Interface(className));
    }

    public final void registerGrayBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_GRAY_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerWhiteBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_WHITE_BUSINESS_CARD, new Interface(className));
    }

    public final void registerWhiteBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_WHITE_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerLaidBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_LAID_BUSINESS_CARD, new Interface(className));
    }

    public final void registerLaidBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_LAID_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerLinenBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_LINEN_BUSINESS_CARD, new Interface(className));
    }

    public final void registerLinenBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_LINEN_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerSmoothBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_SMOOTH_BUSINESS_CARD, new Interface(className));
    }

    public final void registerSmoothBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_SMOOTH_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerSingleSidedBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_SINGLE_SIDED_BUSINESS_CARD, new Interface(className));
    }

    public final void registerSingleSidedBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_SINGLE_SIDED_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerDoubleSidedBusinessCardCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_DOUBLE_SIDED_BUSINESS_CARD, new Interface(className));
    }

    public final void registerDoubleSidedBusinessCardCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CREATE_DOUBLE_SIDED_BUSINESS_CARD, new Interface(className, methodName));
    }

    public final void registerCartCreator(final String className) {
        this.interfaces.put(InterfaceKey.CREATE_CART, new Interface(className));
    }

    public void registerProductAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PRODUCT_ADDER, new Interface(className, methodName));
    }

    public void registerProductRemover(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PRODUCT_REMOVER, new Interface(className, methodName));
    }

    public void registerTotalPriceGetter(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TOTAL_PRICE_GETTER, new Interface(className, methodName));
    }

    public void registerLandscapeBannerTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LANDSCAPE_BANNER_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLandscapeBannerImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LANDSCAPE_BANNER_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerPortraitBannerTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PORTRAIT_BANNER_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerPortraitBannerImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PORTRAIT_BANNER_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerGlossBannerTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.GLOSS_BANNER_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerGlossBannerImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.GLOSS_BANNER_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerScrimBannerTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SCRIM_BANNER_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerScrimBannerImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SCRIM_BANNER_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerMeshBannerTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.MESH_BANNER_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerMeshBannerImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.MESH_BANNER_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLandscapeBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LANDSCAPE_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLandscapeBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LANDSCAPE_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerPortraitBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PORTRAIT_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerPortraitBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.PORTRAIT_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerIvoryBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.IVORY_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerIvoryBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.IVORY_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerGrayBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.GRAY_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerGrayBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.GRAY_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerWhiteBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.WHITE_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerWhiteBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.WHITE_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLaidBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LAID_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLaidBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LAID_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLinenBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LINEN_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerLinenBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.LINEN_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerSmoothBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SMOOTH_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerSmoothBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SMOOTH_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerSingleSidedBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SINGLE_SIDED_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerSingleSidedBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.SINGLE_SIDED_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerDoubleSidedBusinessCardTextApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.DOUBLE_SIDED_BUSINESS_CARD_TEXT_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void registerDoubleSidedBusinessCardImageApertureAdder(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.DOUBLE_SIDED_BUSINESS_CARD_IMAGE_APERTURE_ADDER, new Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "%d unregistered method(s)",
                TOTAL_INTERFACES_COUNT - this.interfaces.size());

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<InterfaceKey, Interface> entry : this.interfaces.entrySet()) {
            Interface aInterface = entry.getValue();
            String className = aInterface.getClassName();

            Class<?> aClass = getClassByNameOrNull(className);

            assertTrue(aClass != null, "not found: %s", className);

            String methodName = aInterface.getMethodName();

            if (methodName != null) {
                ArrayList<Method> methods = getMethodsByName(aClass, methodName);

                assertTrue(methods.size() > 0, "not found: %s.%s()", className, methodName);
            }
        }
    }

    protected void assertTrue(boolean condition, String format, Object... args) {
        assert condition : String.format(format, args);
    }

    private final Class<?> getClassByNameOrNull(final String name) {
        try {
            String fullClassName = String.format("%s.%s", ASSIGNMENT2_PACKAGE_NAME, name);
            return Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private final ArrayList<Method> getMethodsByName(final Class<?> aClass, final String methodName) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        ArrayList<Method> methods = new ArrayList<>();

        for (int i = 0; i < declaredMethods.length; ++i) {
            if (declaredMethods[i].getName().equals(methodName)) {
                methods.add(declaredMethods[i]);
            }
        }

        return methods;
    }
}
