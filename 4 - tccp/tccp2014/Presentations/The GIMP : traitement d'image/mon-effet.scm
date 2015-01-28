 (define (script-fu-mon-effet inImage inCalque inContraste inLuminosite inSaturation)
	(gimp-image-undo-group-start inImage)

	(gimp-brightness-contrast inCalque inLuminosite inContraste)
	(gimp-hue-saturation inCalque ALL-HUES 0 0 inSaturation)
 
	(gimp-image-undo-group-end inImage)
	(gimp-displays-flush)
)
 (script-fu-register
            "script-fu-mon-effet"
            "<Image>/Filters/Tests/Mon effet..."
            "Traitement perso d'une photo"
            "Galand Simon, Latour Pierre-Louis"
            "copyright 2014, Galand Simon, Latour Pierre-Louis"
            "November 25, 2014"
            ""
	    SF-IMAGE	"The Image"	0
	    SF-DRAWABLE	"Calque actif"	0
	    SF-ADJUSTMENT "Contraste" '(20 -100 100 1 1 0 0)
	    SF-ADJUSTMENT "Luminosite" '(20 -100 100 1 1 0 0)
	    SF-ADJUSTMENT "Saturation" '(20 -100 100 1 1 0 0)
 )

