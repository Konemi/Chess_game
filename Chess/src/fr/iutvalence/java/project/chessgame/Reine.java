package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de reine
 */
public class Reine extends Piece
{
    /**
     * Valeur de la coordonnée de la pièce
     */
    private int position;

    /**
     * La liste des différentes positions possible terme de coordonnées
     */
    private final int[][] listPosition = { { position, 0 }, { 0, -position }, { -position, 0 },
            { 0, position }, { position, position }, { position, -position }, { -position, -position },
            { -position, position } };

    /**
     * Créer une reine de couleur donnée
     *
     * @param couleur La couleur de la reine
     */
    public Reine(Color couleur)
    {
        super(couleur);
    }

    /**
     * Détermine les différents movements possible à partir d'une position de
     * départ donnée
     *
     * @param positionDepart La position actuelle de la pièce
     * @return Une liste de tout les déplacements possible à partir d'une
     *         position
     */
    @Override
    public List<Position> possibleMovements(Position positionDepart)
    {
        List<Position> possibleMovement = new ArrayList<Position>();
        Square positionDeFin;
        Position newPosition;
        int i, j;
        for (int[] direction : listPosition)
        {
            for (position = 1; position < 8; position++)
            {
                i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
                {
                    positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                    if (positionDeFin.getPiece() != null)
                    {
                        if (positionDeFin.getPiece().obtenirCouleur() == this.couleur)
                        {
                            break;
                        }
                        possibleMovement.add(newPosition);
                        break;
                    }
                    else
                    {
                        possibleMovement.add(newPosition);
                    }
                }
            }
        }
        return possibleMovement;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "r" + super.toString();
    }

}